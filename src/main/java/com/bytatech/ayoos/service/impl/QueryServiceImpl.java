package com.bytatech.ayoos.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytatech.ayoos.service.QueryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;
import static org.elasticsearch.index.query.QueryBuilders.*;

import static org.elasticsearch.action.search.SearchType.QUERY_THEN_FETCH;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytatech.ayoos.client.appointment.model.Appointment;

import com.bytatech.ayoos.client.doctor.model.*;

import com.bytatech.ayoos.client.patient.model.*;
import com.bytatech.ayoos.service.QueryService;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * Query Service Implementation
 */
@Service
@Transactional
public class QueryServiceImpl implements QueryService {

	private RestHighLevelClient restHighLevelClient;

	private ObjectMapper objectMapper;

	public QueryServiceImpl(ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
		this.objectMapper = objectMapper;
		this.restHighLevelClient = restHighLevelClient;
	}

	@Override
	public Page<Doctor> findAllDoctors(Pageable pageable) {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		/*
		 * String[] includeFields = new String[] { "iDPcode", "image" }; String[]
		 * excludeFields = new String[] { "category.*", "brand.*" };
		 * searchSourceBuilder.fetchSource(includeFields, excludeFields);
		 */

		searchSourceBuilder.query(matchAllQuery());

		SearchRequest searchRequest = generateSearchRequest("doctor", pageable.getPageSize(), pageable.getPageNumber(),
				searchSourceBuilder);
		SearchResponse searchResponse = null;
		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		return getSearchResult(searchResponse, pageable, new Doctor());

	}

	private SearchRequest generateSearchRequest(String indexName, Integer totalElement, Integer pageNumber,
			SearchSourceBuilder sourceBuilder) {
		SearchRequest searchRequest = new SearchRequest(indexName);

		int offset = 0;
		int totalElements = 0;

		if (pageNumber == 0) {
			offset = 0;
			totalElements = totalElement;

		} else {

			offset = totalElement;

			totalElements = (pageNumber * totalElement);

		}
		sourceBuilder.from(offset);
		sourceBuilder.size(totalElements);

		searchRequest.source(sourceBuilder);
		return searchRequest;
	}

	@Override
	public Patient findPatient(String idpCode) {

		SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
		/*
		 * String[] include = new String[] { "", "", "" };
		 * 
		 * searchBuilder.fetchSource(include, exclude);
		 */
		searchBuilder.query(termQuery("idpCode", idpCode));

		SearchRequest searchRequest = new SearchRequest("patient");

		searchRequest.source(searchBuilder);
		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}

		return getResult1(searchResponse, new Patient());
	}

	@Override
	public List<String> findAllQualifications(Pageable pageable) {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		/*
		 * String[] includeFields = new String[] { "iDPcode", "image" }; String[]
		 * excludeFields = new String[] { "category.*", "brand.*" };
		 * searchSourceBuilder.fetchSource(includeFields, excludeFields);
		 */

		searchSourceBuilder.query(matchAllQuery());

		SearchRequest searchRequest = generateSearchRequest("qualification", pageable.getPageSize(),
				pageable.getPageNumber(), searchSourceBuilder);
		SearchResponse searchResponse = null;
		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		return getSearchResult(searchResponse, pageable, new Qualification()).getContent();

	}

	/*
	 * @Override public List<String> findAllQualifications(Pageable pageable) {
	 * List<String> qualificationList = new ArrayList<String>(); SearchQuery
	 * searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
	 * .withSearchType(QUERY_THEN_FETCH).withIndices("qualification").withTypes(
	 * "qualification")
	 * .addAggregation(AggregationBuilders.terms("distinct_qualification").field(
	 * "qualification.keyword")) .build();
	 * 
	 * AggregatedPage<Qualification> result =
	 * elasticsearchTemplate.queryForPage(searchQuery, Qualification.class);
	 * TermsAggregation subjectAgg = result.getAggregation("distinct_qualification",
	 * TermsAggregation.class);
	 * 
	 * List<Entry> bucket = subjectAgg.getBuckets();
	 * 
	 * for (int i = 0; i < subjectAgg.getBuckets().size(); i++) {
	 * qualificationList.add(subjectAgg.getBuckets().get(i).getKey()); }
	 * 
	 * 
	 * return qualificationList;
	 * 
	 * }
	 */

	@Override
	public Optional<Doctor> findDoctorByDoctorId(String doctorId) {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		searchSourceBuilder.query(termQuery("doctorId", doctorId));

		SearchRequest searchRequest = new SearchRequest("doctor");
		searchRequest.source(searchSourceBuilder);
		SearchResponse searchResponse = null;
		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		SearchHit[] searchHit = searchResponse.getHits().getHits();

		List<Doctor> list = new ArrayList<>();

		for (SearchHit hit : searchHit) {
			list.add(objectMapper.convertValue(hit.getSourceAsMap(), Doctor.class));
		}
		return Optional.of(list.get(0));

	}

	private <T> T getResult(SearchResponse response, T t) {

		SearchHit[] searchHit = response.getHits().getHits();

		List<T> list = new ArrayList<>();

		for (SearchHit hit : searchHit) {
			list.add((T) objectMapper.convertValue(hit.getSourceAsMap(), t.getClass()));
		}

		return list.get(0);

	}

	private <T> T getResult1(SearchResponse response, T t) {

		SearchHit[] searchHit = response.getHits().getHits();
		T type = null;

		for (SearchHit hit : searchHit) {

			type = (T) objectMapper.convertValue(hit.getSourceAsMap(), t.getClass());
		}

		return type;

	}

	private <T> Page getSearchResult(SearchResponse response, Pageable page, T t) {
		SearchHit[] searchHit = response.getHits().getHits();

		List<T> list = new ArrayList<>();

		for (SearchHit hit : searchHit) {
			list.add((T) objectMapper.convertValue(hit.getSourceAsMap(), t.getClass()));
		}

		return new PageImpl(list, page, response.getHits().getTotalHits());

	}

	@Override
	public Appointment findAppointmentByTrackingId(String trackingId) {

		// termQuery("trackingId.keyword", trackingId).toString()
		SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
		/*
		 * String[] include = new String[] { "", "", "" };
		 * 
		 * searchBuilder.fetchSource(include, exclude);
		 */
		searchBuilder.query(termQuery("trackingId.keyword", trackingId));

		SearchRequest searchRequest = new SearchRequest("appointment");

		searchRequest.source(searchBuilder);
		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}

		return getResult1(searchResponse, new Appointment());
	}

	/*
	 * @Override public List<String> findAllQualifications(Pageable pageable) {
	 * List<String> qualificationList = new ArrayList<String>(); SearchQuery
	 * searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
	 * .withSearchType(QUERY_THEN_FETCH).withIndices("qualification").withTypes(
	 * "qualification")
	 * .addAggregation(AggregationBuilders.terms("distinct_qualification").field(
	 * "qualification.keyword")) .build();
	 * 
	 * AggregatedPage<Qualification> result =
	 * elasticsearchTemplate.queryForPage(searchQuery, Qualification.class);
	 * TermsAggregation subjectAgg = result.getAggregation("distinct_qualification",
	 * TermsAggregation.class);
	 * 
	 * List<Entry> bucket = subjectAgg.getBuckets();
	 * 
	 * for (int i = 0; i < subjectAgg.getBuckets().size(); i++) {
	 * qualificationList.add(subjectAgg.getBuckets().get(i).getKey()); }
	 * 
	 * 
	 * return qualificationList;
	 * 
	 * }
	 *
	 * @Override public Page<Doctor> facetSearch(String specialization, Double
	 * ratings, Double feeFrom, Double feeTo, Pageable pageable) {
	 * 
	 * List<QueryBuilders> queryList = new ArrayList<QueryBuilders>(); //
	 * QueryBuilders.matchQuery("specialization", specialization); // queryList.add(
	 * QueryBuilders.matchQuery("totalRatings", ratings)); // queryList.add(
	 * QueryBuilders.rangeQuery("fees").gte("feeFrom").lte("feeTo")); //
	 * queryList.add( QueryBuilders.matchQuery("workplace.name", workplaceName));
	 * 
	 * SearchQuery searchQuery = new
	 * NativeSearchQueryBuilder().withQuery(matchAllQuery())
	 * 
	 * .withFilter(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery(
	 * "specialization", specialization))
	 * .should(QueryBuilders.matchQuery("totalRatings", ratings))
	 * .should(QueryBuilders.rangeQuery("paymentSettings.amount").gte("fr").lte("to"
	 * )) .should(QueryBuilders.matchQuery("workplace.name", workplaceName))
	 * ).build(); return elasticsearchOperations.queryForPage(searchQuery,
	 * Doctor.class); }
	 * 
	 * 
	 * 
	 */
	@Override
	public Page<Review> findReviewByDoctorId(String doctorId, Pageable pageable) {

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		/*
		 * String[] includeFields = new String[] { "iDPcode", "image" }; String[]
		 * excludeFields = new String[] { "category.*", "brand.*" };
		 * searchSourceBuilder.fetchSource(includeFields, excludeFields);
		 */

		searchSourceBuilder.query(matchQuery("doctor.doctorId", doctorId));

		SearchRequest searchRequest = generateSearchRequest("review", pageable.getPageSize(), pageable.getPageNumber(),
				searchSourceBuilder);
		SearchResponse searchResponse = null;
		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		return getSearchResult(searchResponse, pageable, new Review());

	}

	@Override
	public Page<Doctor> findDoctors(String searchTerm, Pageable pageable) {

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		/*
		 * String[] includeFields = new String[] { "iDPcode", "image" }; String[]
		 * excludeFields = new String[] { "category.*", "brand.*" };
		 * searchSourceBuilder.fetchSource(includeFields, excludeFields);
		 */

		searchSourceBuilder.query(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("doctorId", searchTerm))
				.should(QueryBuilders.matchQuery("specialization", searchTerm)));

		SearchRequest searchRequest = generateSearchRequest("doctor", pageable.getPageSize(), pageable.getPageNumber(),
				searchSourceBuilder);
		SearchResponse searchResponse = null;
		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		return getSearchResult(searchResponse, pageable, new Doctor());

	}

	/*
	 * @Override public List<WorkPlace> findByLocationWithin(Point point, Distance
	 * distance) {
	 * 
	 * return elasticsearchTemplate.queryForList(getGeoQuery(point, distance),
	 * WorkPlace.class);
	 * 
	 * }
	 * 
	 * private CriteriaQuery getGeoQuery(Point point, Distance distance) { return
	 * new CriteriaQuery(new Criteria("location").within(point, distance)); }
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bytatech.ayoos.service.QueryService#findRatingByDoctorIdAndPatientName(
	 * java.lang.String, java.lang.String)
	 */

	@Override
	public UserRating findRatingByDoctorIdAndPatientName(String doctorId, String patientCode) {

		SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
		/*
		 * String[] include = new String[] { "", "", "" };
		 * 
		 * searchBuilder.fetchSource(include, exclude);
		 */
		searchBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("doctor.doctorId", doctorId))
				.must(QueryBuilders.termQuery("userName", patientCode)));

		SearchRequest searchRequest = new SearchRequest("userrating");

		searchRequest.source(searchBuilder);
		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}

		return getResult1(searchResponse, new UserRating());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bytatech.ayoos.service.QueryService#findReviewByDoctorIdAndPatientName(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Review findReviewByDoctorIdAndPatientName(String doctorId, String patientCode) {

		SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
		/*
		 * String[] include = new String[] { "", "", "" };
		 * 
		 * searchBuilder.fetchSource(include, exclude);
		 */
		searchBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("doctor.doctorId", doctorId))
				.must(QueryBuilders.termQuery("userName", patientCode)));

		SearchRequest searchRequest = new SearchRequest("review");

		searchRequest.source(searchBuilder);
		SearchResponse searchResponse = null;

		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}

		return getResult1(searchResponse, new Review());
	}
	
	  @Override public Page<Patient> findAllPatientWithoutSearch(Pageable pageable)
	  {  
		  SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			/*
			 * String[] includeFields = new String[] { "iDPcode", "image" }; String[]
			 * excludeFields = new String[] { "category.*", "brand.*" };
			 * searchSourceBuilder.fetchSource(includeFields, excludeFields);
			 */

			searchSourceBuilder.query(matchAllQuery());

			SearchRequest searchRequest = generateSearchRequest("patient", pageable.getPageSize(), pageable.getPageNumber(),
					searchSourceBuilder);
			SearchResponse searchResponse = null;
			try {
				searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			} catch (IOException e) { // TODO Auto-generated
				e.printStackTrace();
			}
			return getSearchResult(searchResponse, pageable, new Patient());
		  
	  }
	 
}
