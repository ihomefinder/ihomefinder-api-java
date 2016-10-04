package com.ihomefinder.api;

public class Url {
		
		private static final String PREFIX = Constants.DOMAIN + "/api/v1/client";
		private static final String SUFFIX = ".json";
		
		public static final String CLIENT = PREFIX + SUFFIX;
		public static final String CLIENT_BOARDS = PREFIX + "/clientBoards" + SUFFIX;
		public static final String CLIENT_BOARD = PREFIX + "/clientBoard/{clientBoardId}" + SUFFIX;
		public static final String BOARDS = PREFIX + "/boards" + SUFFIX;
		public static final String BOARD = PREFIX + "/board/{boardId}" + SUFFIX;
		public static final String LISTINGS = PREFIX + "/listings" + SUFFIX;
		public static final String LISTING = PREFIX + "/listing/{listingId}" + SUFFIX;
		public static final String SUBSCRIBERS = PREFIX + "/subscribers" + SUFFIX;
		public static final String SUBSCRIBER = PREFIX + "/subscriber/{subscriberId}" + SUFFIX;
		public static final String MARKETS = PREFIX + "/markets" + SUFFIX;
		public static final String MARKET = PREFIX + "/market/{marketId}" + SUFFIX;
		public static final String LISTING_REPORT = PREFIX + "/listingReport/{listingReportId}" + SUFFIX;
		public static final String OPEN_HOME_REPORT = PREFIX + "/openHomeReport/{openHomeReportId}" + SUFFIX;
		public static final String MARKET_REPORT = PREFIX + "/marketReport/{marketReportId}" + SUFFIX;
		public static final String LISTING_REPORT_SUBSCRIPTIONS = PREFIX + "/listingReport/{listingReportId}/subscriptions" + SUFFIX;	
		public static final String LISTING_REPORT_SUBSCRIPTION = PREFIX + "/listingReport/{listingReportId}/subscription/{listingReportSubscriptionId}" + SUFFIX;	
		public static final String OPEN_HOME_REPORT_SUBSCRIPTIONS = PREFIX + "/openHomeReport/{openHomeReportId}/subscriptions" + SUFFIX;	
		public static final String OPEN_HOME_REPORT_SUBSCRIPTION = PREFIX + "/openHomeReport/{openHomeReportId}/subscription/{openHomeReportSubscriptionId}" + SUFFIX;	
		public static final String MARKET_REPORT_SUBSCRIPTIONS = PREFIX + "/marketReport/{marketReportId}/subscriptions" + SUFFIX;	
		public static final String MARKET_REPORT_SUBSCRIPTION = PREFIX + "/marketReport/{marketReportId}/subscription/{marketReportSubscriptionId}" + SUFFIX;
		public static final String AGENTS = PREFIX + "/agents" + SUFFIX;
		public static final String AGENT = PREFIX + "/agent/{agentId}" + SUFFIX;
		public static final String OFFICES = PREFIX + "/offices" + SUFFIX;
		public static final String OFFICE = PREFIX + "/office/{id}" + SUFFIX;
		public static final String MORE_INFO_REQUESTS = PREFIX + "/moreInfoRequests" + SUFFIX;
		public static final String MORE_INFO_REQUEST = PREFIX + "/moreInfoRequest/{moreInfoRequestId}" + SUFFIX;
		public static final String SCHEDULE_SHOWING_REQUESTS = PREFIX + "/scheduleShowingRequests" + SUFFIX;
		public static final String SCHEDULE_SHOWING_REQUEST = PREFIX + "/scheduleShowingRequest/{scheduleShowingRequestId}" + SUFFIX;
		public static final String CONTACT_REQUESTS = PREFIX + "/contactRequests" + SUFFIX;
		public static final String CONTACT_REQUEST = PREFIX + "/contactRequest/{contactRequestId}" + SUFFIX;
		public static final String VALUATION_REQUESTS = PREFIX + "/valuationRequests" + SUFFIX;
		public static final String VALUATION_REQUEST = PREFIX + "/valuationRequest/{valuationRequestId}" + SUFFIX;
		public static final String EMAIL_UPDATE_SIGNUP_REQUESTS = PREFIX + "/emailUpdateSignupRequests" + SUFFIX;
		public static final String EMAIL_UPDATE_SIGNUP_REQUEST = PREFIX + "/emailUpdateSignupRequest/{emailUpdateSignupRequestId}" + SUFFIX;
		public static final String PROPERTY_ORGANIZER_SIGNUP_REQUESTS = PREFIX + "/propertyOrganizerSignupRequests" + SUFFIX;
		public static final String PROPERTY_ORGANIZER_SIGNUP_REQUEST = PREFIX + "/propertyOrganizerSignupRequest/{propertyOrganizerSignupRequestId}" + SUFFIX;
		public static final String LISTING_REPORT_SIGNUP_REQUESTS = PREFIX + "/listingReportSignupRequests" + SUFFIX;
		public static final String LISTING_REPORT_SIGNUP_REQUEST = PREFIX + "/listingReportSignupRequest/{listingReportSignupRequestId}" + SUFFIX;
		public static final String OPEN_HOME_REPORT_SIGNUP_REQUESTS = PREFIX + "/openHomeReportSignupRequests" + SUFFIX;
		public static final String OPEN_HOME_REPORT_SIGNUP_REQUEST = PREFIX + "/openHomeReportSignupRequest/{openHomeReportSignupRequestId}" + SUFFIX;
		public static final String MARKET_REPORT_SIGNUP_REQUESTS = PREFIX + "/marketReportSignupRequests" + SUFFIX;
		public static final String MARKET_REPORT_SIGNUP_REQUEST = PREFIX + "/marketReportSignupRequest/{marketReportSignupRequestId}" + SUFFIX;
		
	}