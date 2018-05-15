package com.notDefault.gc;

public class DVD {
	public class book {
		private int number;
		private String DvdTitle;
		private String Director;
		public String status;
		private long dueDate;

			public book(int number,String bookTitle, String status) {
				super();
				this.number = number;
				this.DvdTitle = DvdTitle;
				this.Director=Director;
				this.status= status;
		        this.dueDate= dueDate;
		        
		        
		        
			}

			public int getNumber() {
				return number;
			}

			public void setNumber(int number) {
				this.number = number;
			}

			public String getDvdTitle() {
				return DvdTitle;
			}

			public void setDvdTitle(String dvdTitle) {
				DvdTitle = dvdTitle;
			}

			public String getDirector() {
				return Director;
			}

			public void setDirector(String director) {
				Director = director;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public long getDueDate() {
				return dueDate;
			}

			public void setDueDate(long dueDate) {
				this.dueDate = dueDate;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return number+" "+DvdTitle+" "+Director+" "+status+" "+dueDate;
			}
			
}
}