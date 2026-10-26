package org.bjm.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jspecify.annotations.Nullable;
import org.springframework.web.multipart.MultipartFile;

public class CustomMultipartFile implements MultipartFile {

	private byte[] imageBytes;
	private String originalFileName;
	
	
	public CustomMultipartFile(byte[] imageBytes, String originalFileName) {
		super();
		this.imageBytes = imageBytes;
		this.originalFileName = originalFileName;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}



	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable String getOriginalFilename() {
		return originalFileName;
	}

	@Override
	public @Nullable String getContentType() {
		String contentType = originalFileName.substring(originalFileName.lastIndexOf('.'));
		return contentType;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public long getSize() {
		return imageBytes.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return imageBytes;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(imageBytes);
	}

	@Override
	public void transferTo(File destination) throws IOException, IllegalStateException {
		try(FileOutputStream fos = new FileOutputStream(destination)) {
            fos.write(imageBytes);
        }

	}

}
