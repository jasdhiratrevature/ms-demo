package com.revature.notification.event;

public class CurrencyEvent {
	 private Long id;
	    private String from;
	    private String to;
		public CurrencyEvent() {
			
		}
		public CurrencyEvent(Long id, String from, String to) {
			this.id = id;
			this.from = from;
			this.to = to;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		@Override
		public String toString() {
			return "CurrencyEvent [id=" + id + ", from=" + from + ", to=" + to + "]";
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
	    
}
