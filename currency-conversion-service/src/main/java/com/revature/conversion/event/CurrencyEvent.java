package com.revature.conversion.event;

import org.springframework.context.ApplicationEvent;

public class CurrencyEvent extends ApplicationEvent {
	 private Long id;
	    private String from;
	    private String to;
		
		public CurrencyEvent(Object source,Long id, String from, String to) {
			super(source);
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
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
	    
}
