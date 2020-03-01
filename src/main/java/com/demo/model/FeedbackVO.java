package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="add_feedback")
public class FeedbackVO {
			
		@Id
		@Column(name="feedback_Id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int feedbackId;
		
		@Column(name="feedback_title")
		private String feedbackTitle;
		
		@Column(name="feedback_description")
		private String feedbackDescription;
		
		@Column(name="feedback_rating")
		private String feedbackRating;

		@Column
		private Boolean status = true;
		
		@ManyToOne
		private LoginVO loginVO;
		
		public LoginVO getLoginVO() {
			return loginVO;
		}

		public void setLoginVO(LoginVO loginVO) {
			this.loginVO = loginVO;
		}

		public String getFeedbackRating() {
			return feedbackRating;
		}

		public void setFeedbackRating(String feedbackRating) {
			this.feedbackRating = feedbackRating;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public int getFeedbackId() {
			return feedbackId;
		}

		public void setFeedbackId(int feedbackId) {
			this.feedbackId = feedbackId;
		}

		public String getFeedbackTitle() {
			return feedbackTitle;
		}

		public void setFeedbackTitle(String feedbackTitle) {
			this.feedbackTitle = feedbackTitle;
		}

		public String getFeedbackDescription() {
			return feedbackDescription;
		}

		public void setFeedbackDescription(String feedbackDescription) {
			this.feedbackDescription = feedbackDescription;
		}

}
