/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.ayoos.client.appointment.api;

import com.bytatech.ayoos.client.appointment.model.ConsultationInfoDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-16T11:23:29.803+05:30[Asia/Kolkata]")

@Api(value = "ConsultationInfoResource", description = "the ConsultationInfoResource API")
public interface ConsultationInfoResourceApi {

    @ApiOperation(value = "createConsultationInfo", nickname = "createConsultationInfoUsingPOST", notes = "", response = ConsultationInfoDTO.class, tags={ "consultation-info-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ConsultationInfoDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/consultation-infos",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<ConsultationInfoDTO> createConsultationInfoUsingPOST(@ApiParam(value = "consultationInfoDTO" ,required=true )  @Valid @RequestBody ConsultationInfoDTO consultationInfoDTO);


    @ApiOperation(value = "deleteConsultationInfo", nickname = "deleteConsultationInfoUsingDELETE", notes = "", tags={ "consultation-info-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/consultation-infos/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteConsultationInfoUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllConsultationInfos", nickname = "getAllConsultationInfosUsingGET", notes = "", response = ConsultationInfoDTO.class, responseContainer = "List", tags={ "consultation-info-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ConsultationInfoDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/consultation-infos",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<ConsultationInfoDTO>> getAllConsultationInfosUsingGET(@ApiParam(value = "") @Valid @RequestParam(value = "offset", required = false) Long offset,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,@ApiParam(value = "") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "") @Valid @RequestParam(value = "paged", required = false) Boolean paged,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort,@ApiParam(value = "") @Valid @RequestParam(value = "sort.sorted", required = false) Boolean sortSorted,@ApiParam(value = "") @Valid @RequestParam(value = "sort.unsorted", required = false) Boolean sortUnsorted,@ApiParam(value = "") @Valid @RequestParam(value = "unpaged", required = false) Boolean unpaged);


    @ApiOperation(value = "getConsultationInfo", nickname = "getConsultationInfoUsingGET", notes = "", response = ConsultationInfoDTO.class, tags={ "consultation-info-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ConsultationInfoDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/consultation-infos/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<ConsultationInfoDTO> getConsultationInfoUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchConsultationInfos", nickname = "searchConsultationInfosUsingGET", notes = "", response = ConsultationInfoDTO.class, responseContainer = "List", tags={ "consultation-info-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ConsultationInfoDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/consultation-infos",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<ConsultationInfoDTO>> searchConsultationInfosUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "") @Valid @RequestParam(value = "offset", required = false) Long offset,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,@ApiParam(value = "") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "") @Valid @RequestParam(value = "paged", required = false) Boolean paged,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort,@ApiParam(value = "") @Valid @RequestParam(value = "sort.sorted", required = false) Boolean sortSorted,@ApiParam(value = "") @Valid @RequestParam(value = "sort.unsorted", required = false) Boolean sortUnsorted,@ApiParam(value = "") @Valid @RequestParam(value = "unpaged", required = false) Boolean unpaged);


    @ApiOperation(value = "updateConsultationInfo", nickname = "updateConsultationInfoUsingPUT", notes = "", response = ConsultationInfoDTO.class, tags={ "consultation-info-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ConsultationInfoDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/consultation-infos",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<ConsultationInfoDTO> updateConsultationInfoUsingPUT(@ApiParam(value = "consultationInfoDTO" ,required=true )  @Valid @RequestBody ConsultationInfoDTO consultationInfoDTO);

}
