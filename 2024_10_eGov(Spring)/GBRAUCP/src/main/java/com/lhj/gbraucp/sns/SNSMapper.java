package com.lhj.gbraucp.sns;

import java.util.List;

public interface SNSMapper {
	public abstract int write(SNSPost sp);
	public abstract List<SNSPost> get(SNSPostSelector sp);
	public abstract int getPostCount(SNSPostSelector sp);
	public abstract int delete(SNSPost sp);
	public abstract int update(SNSPost sp);
	public abstract int writeReply(SNSReply sr);
	public abstract List<SNSReply> getReply(SNSPost sp);
	public abstract int updateReply(SNSReply sr);
	public abstract int deleteReply(SNSReply sr);
}
