package com.lhj.gbraucp.gallery;

import java.util.List;

public interface PhotoMapper {
	public abstract int insertPhoto(Photo p);
	public abstract List<Photo> getPhoto();
	public abstract int deletePhoto(Photo p);
}
