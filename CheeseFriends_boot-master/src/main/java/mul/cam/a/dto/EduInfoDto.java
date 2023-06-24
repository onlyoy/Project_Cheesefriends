package mul.cam.a.dto;

public class EduInfoDto {
	private int seq;
	private String subject;
	private String subjectCode;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String filename;
	
	public EduInfoDto() {
		
	}
	
	

	public EduInfoDto(int seq, String subject, String subjectCode, String title, String writer, String content,
			String regdate, String filename) {
		super();
		this.seq = seq;
		this.subject = subject;
		this.subjectCode = subjectCode;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.filename = filename;
	}



	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getSubjectCode() {
		return subjectCode;
	}



	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	@Override
	public String toString() {
		return "EduInfoDto [seq=" + seq + ", subject=" + subject + ", subjectCode=" + subjectCode + ", title=" + title
				+ ", writer=" + writer + ", content=" + content + ", regdate=" + regdate + ", filename=" + filename
				+ "]";
	}	
	
	
	
}
