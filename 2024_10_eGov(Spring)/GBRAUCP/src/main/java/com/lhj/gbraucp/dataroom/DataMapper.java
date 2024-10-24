package com.lhj.gbraucp.dataroom;

import java.util.List;

public interface DataMapper {
	public abstract int insertData(Data d);
	public abstract List<Data> getData(Data d);
	public abstract int deleteData(Data d);
}
