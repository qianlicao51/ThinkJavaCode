package com.zhuziym.a.char14.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * @Title: Demo01.java
 * @Package com.zhuziym.a.char14.zip
 * @Description: TODO(压缩文件)
 * @author 作者 grq
 * @version 创建时间：2018年8月30日 下午3:55:35
 *
 */
public class Demo01 {
	/********************************************************
	 * 单个文件的操作
	 *********************************************************
	 */
	/**
	 * 压缩文件
	 * 
	 * @throws Exception
	 */
	@Test
	public void gzipDemo() throws Exception {
		InputStream in = null;
		String fileName = "c://1.png";
		String gzipFileName = fileName + ".zip";
		OutputStream out = null;
		in = new BufferedInputStream(new FileInputStream(fileName));
		out = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(gzipFileName)));
		IOUtils.copy(in, out);
		IOUtils.closeQuietly(out);
		IOUtils.closeQuietly(in);
	}

	/**
	 * 解压文件
	 */
	@Test
	public void gunzipDemo() {
		InputStream in = null;
		OutputStream out = null;
		String gzipFileName = "c://1.png.zip";
		String unzipFileName = "e://1.png";
		try {
			in = new GZIPInputStream(new BufferedInputStream(new FileInputStream(gzipFileName)));
			out = new BufferedOutputStream(new FileOutputStream(unzipFileName));
			IOUtils.copy(in, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		IOUtils.closeQuietly(out);
		IOUtils.closeQuietly(in);

	}

	@Test
	public void testFileType() throws IOException {
		String gzipFileName = "c://1.png.zip";
		String probeContentType = Files.probeContentType(Paths.get(gzipFileName));
		System.out.println(probeContentType);

	}

	// ///////////////////////////////////////
	// 多个文件的加压与解压
	// ///////////////////////////////////////
	/**
	 * 压缩一个文件或一个目录
	 * 
	 * @param inFile
	 * @param zipFile
	 * @throws IOException
	 */
	public static void zip(File inFile, File zipFile) throws IOException {
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));

		try {
			if (!inFile.exists()) {
				throw new FileNotFoundException(inFile.getAbsolutePath());
			}
			// TODO 返回这个抽象路径名的规范形式。相当于新文件
			inFile = inFile.getCanonicalFile();
			String rootPath = inFile.getParent();
			if (!rootPath.endsWith(File.separator)) {
				rootPath += File.separator;
			}
			addFileToZipOut(inFile, out, rootPath);
		} finally {
			org.apache.commons.compress.utils.IOUtils.closeQuietly(out);
		}

	}

	private static void addFileToZipOut(File file, ZipOutputStream out, String rootPath) throws IOException {
		String relativePath = file.getCanonicalPath().substring(rootPath.length());
		if (file.isFile()) {
			out.putNextEntry(new ZipEntry(relativePath));
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			try {
				IOUtils.copy(in, out);
			} finally {
				IOUtils.closeQuietly(in);
			}
		} else {
			out.putNextEntry(new ZipEntry(relativePath + File.separator));
			for (File f : file.listFiles()) {
				addFileToZipOut(f, out, rootPath);
			}
		}
	}

	/**
	 * 解压文件
	 * 
	 * @param zipFile
	 *            压缩的文件
	 * @param destDIr
	 *            解压目录
	 * @throws FileNotFoundException
	 */
	public static void unzip(File zipFile, String destDIr) throws IOException {

		ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));

		if (!destDIr.endsWith(File.separator)) {
			destDIr += File.separator;
		}
		try {
			ZipEntry entry = zin.getNextEntry();
			while (entry != null) {
				extractZipEntry(entry, zin, destDIr);
				entry = zin.getNextEntry();
				boolean directory = entry.isDirectory();
				System.out.println(entry.getName()+directory);
			}
		} finally {
			IOUtils.closeQuietly(zin);
		}

	}

	/**
	 * 处理每个压缩条目
	 * 
	 * @param entry
	 * @param zin
	 * @param destDIr
	 * @throws IOException
	 */
	private static void extractZipEntry(ZipEntry entry, ZipInputStream zin,
			String destDir) throws IOException {
		if (!entry.isDirectory()) {
			File parent = new File(destDir + entry.getName()).getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			OutputStream entryOut = new BufferedOutputStream(new FileOutputStream(destDir + entry.getName()));
			try {
				IOUtils.copy(zin, entryOut);
			} finally {
				IOUtils.closeQuietly(entryOut);
			}
		} else {
			new File(destDir + entry.getName()).mkdirs();
		}
	}

	public static void main(String[] args) throws IOException {
		// zip(Paths.get("C:/nvw/").toFile(),
		// Paths.get("c://27348.zip").toFile());
		unzip(Paths.get("c://27348.zip").toFile(), "c://hehedawaa");
		// File inFile = Paths.get("C:/nvw/27348").toFile();
		// String rootPath = inFile.getParent();
		// if (!rootPath.endsWith(File.separator)) {
		// rootPath += File.separator;
		// }
		// System.out.println(rootPath);
	}
}
