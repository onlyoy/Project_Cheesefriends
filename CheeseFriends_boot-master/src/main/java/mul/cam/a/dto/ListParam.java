package mul.cam.a.dto;

public class ListParam {
	private String choice;	//	제목/내용/작성
	private String search;	//	검색어
	private int pageNumber;	//	[1][2][3]
	
	private int start;
	private int end;
	private String category;
	
	public ListParam() {
		// TODO Auto-generated constructor stub
	}
	
	public ListParam(String choice, String search, int pageNumber, int start, int end, String category) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ListParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + ", start=" + start
				+ ", end=" + end + ", category=" + category + "]";
	}
	
	
}
