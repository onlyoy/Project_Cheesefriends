package mul.cam.a.dto;

import java.io.Serializable;

public class MailParam implements Serializable {

	private String choice;	// 제목/내용/작성자
	private String search;	// 검색어
	private int pageNumber; // [1][2][3]
	private String educode;	// 교육기관 코드
	private String subcode;	// 과목
	private String receiver;
	private String sender;
	
	private int start;
	private int end;
	
	public MailParam() {
		// TODO Auto-generated constructor stub
	}

	public MailParam(String choice, String search, int pageNumber, String educode, String subcode, String receiver,
			String sender, int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
		this.educode = educode;
		this.subcode = subcode;
		this.receiver = receiver;
		this.sender = sender;
		this.start = start;
		this.end = end;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getEducode() {
		return educode;
	}

	public void setEducode(String educode) {
		this.educode = educode;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "MailParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + ", educode="
				+ educode + ", subcode=" + subcode + ", receiver=" + receiver + ", sender=" + sender + ", start="
				+ start + ", end=" + end + "]";
	}

	
	
	
	
}
