package com.ihomefinder.api;

public class Url {
		
		private static final String PREFIX =  Constants.DOMAIN + "/api/v1";
		private static final String SUFFIX = ".json";
		
		public static final String CLIENT = PREFIX + "/client" + SUFFIX;
		public static final String CLIENT_BOARDS = PREFIX + "/client/clientBoards" + SUFFIX;
		public static final String CLIENT_BOARD = PREFIX + "/client/clientBoard/{clientBoardId}" + SUFFIX;
		public static final String BOARDS = PREFIX + "/client/boards" + SUFFIX;
		public static final String BOARD = PREFIX + "/client/board/{boardId}" + SUFFIX;
		public static final String LISTINGS = PREFIX + "/client/listings" + SUFFIX;
		public static final String LISTING = PREFIX + "/client/listing/{listingId}" + SUFFIX;
		public static final String SUBSCRIBERS = PREFIX + "/client/subscribers" + SUFFIX;
		public static final String SUBSCRIBER = PREFIX + "/client/subscriber/{subscriberId}" + SUFFIX;
		public static final String MARKETS = PREFIX + "/client/markets" + SUFFIX;
		public static final String MARKET = PREFIX + "/client/market/{marketId}" + SUFFIX;
		public static final String LISTING_REPORT = PREFIX + "/client/listingReport/{listingReportId}" + SUFFIX;
		public static final String OPEN_HOME_REPORT = PREFIX + "/client/openHomeReport/{openHomeReportId}" + SUFFIX;
		public static final String MARKET_REPORT = PREFIX + "/client/marketReport/{marketReportId}" + SUFFIX;
		public static final String LISTING_REPORT_SUBSCRIPTIONS = PREFIX + "/listingReport/{listingReportId}/subscriptions" + SUFFIX;	
		public static final String LISTING_REPORT_SUBSCRIPTION = PREFIX + "/listingReport/{listingReportId}/subscription/{listingReportSubscriptionId}" + SUFFIX;	
		public static final String OPEN_HOME_REPORT_SUBSCRIPTIONS = PREFIX + "/openHomeReport/{openHomeReportId}/subscriptions" + SUFFIX;	
		public static final String OPEN_HOME_REPORT_SUBSCRIPTION = PREFIX + "/openHomeReport/{openHomeReportId}/subscription/{openHomeReportSubscriptionId}" + SUFFIX;	
		public static final String MARKET_REPORT_SUBSCRIPTIONS = PREFIX + "/marketReport/{marketReportId}/subscriptions" + SUFFIX;	
		public static final String MARKET_REPORT_SUBSCRIPTION = PREFIX + "/marketReport/{marketReportId}/subscription/{marketReportSubscriptionId}" + SUFFIX;
		public static final String AGENTS = PREFIX + "/client/agents" + SUFFIX;
		public static final String AGENT = PREFIX + "/client/agent/{agentId}" + SUFFIX;
		public static final String OFFICES = PREFIX + "/client/offices" + SUFFIX;
		public static final String OFFICE = PREFIX + "/client/office/{id}" + SUFFIX;
		public static final String MORE_INFO_REQUESTS = PREFIX + "/client/moreInfoRequests" + SUFFIX;
		public static final String MORE_INFO_REQUEST = PREFIX + "/client/moreInfoRequest/{moreInfoRequestId}" + SUFFIX;
		public static final String SCHEDULE_SHOWING_REQUESTS = PREFIX + "/client/scheduleShowingRequests" + SUFFIX;
		public static final String SCHEDULE_SHOWING_REQUEST = PREFIX + "/client/scheduleShowingRequest/{scheduleShowingRequestId}" + SUFFIX;
		public static final String CONTACT_REQUESTS = PREFIX + "/client/contactRequests" + SUFFIX;
		public static final String CONTACT_REQUEST = PREFIX + "/client/contactRequest/{contactRequestId}" + SUFFIX;
		public static final String VALUATION_REQUESTS = PREFIX + "/client/valuationRequests" + SUFFIX;
		public static final String VALUATION_REQUEST = PREFIX + "/client/valuationRequest/{valuationRequestId}" + SUFFIX;
		public static final String EMAIL_UPDATE_SIGNUP_REQUESTS = PREFIX + "/client/emailUpdateSignupRequests" + SUFFIX;
		public static final String EMAIL_UPDATE_SIGNUP_REQUEST = PREFIX + "/client/emailUpdateSignupRequest/{emailUpdateSignupRequestId}" + SUFFIX;
		public static final String PROPERTY_ORGANIZER_SIGNUP_REQUESTS = PREFIX + "/client/propertyOrganizerSignupRequests" + SUFFIX;
		public static final String PROPERTY_ORGANIZER_SIGNUP_REQUEST = PREFIX + "/client/propertyOrganizerSignupRequest/{propertyOrganizerSignupRequestId}" + SUFFIX;
		public static final String LISTING_REPORT_SIGNUP_REQUESTS = PREFIX + "/client/listingReportSignupRequests" + SUFFIX;
		public static final String LISTING_REPORT_SIGNUP_REQUEST = PREFIX + "/client/listingReportSignupRequest/{listingReportSignupRequestId}" + SUFFIX;
		public static final String OPEN_HOME_REPORT_SIGNUP_REQUESTS = PREFIX + "/client/openHomeReportSignupRequests" + SUFFIX;
		public static final String OPEN_HOME_REPORT_SIGNUP_REQUEST = PREFIX + "/client/openHomeReportSignupRequest/{openHomeReportSignupRequestId}" + SUFFIX;
		public static final String MARKET_REPORT_SIGNUP_REQUESTS = PREFIX + "/client/marketReportSignupRequests" + SUFFIX;
		public static final String MARKET_REPORT_SIGNUP_REQUEST = PREFIX + "/client/marketReportSignupRequest/{marketReportSignupRequestId}" + SUFFIX;
		
	}