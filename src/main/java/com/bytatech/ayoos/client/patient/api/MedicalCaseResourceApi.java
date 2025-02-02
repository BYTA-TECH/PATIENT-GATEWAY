/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.ayoos.client.patient.api;

import com.bytatech.ayoos.client.patient.model.MedicalCaseDTO;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-28T11:07:58.008+05:30[Asia/Kolkata]")

@Api(value = "MedicalCaseResource", description = "the MedicalCaseResource API")
public interface MedicalCaseResourceApi {

    @ApiOperation(value = "createMedicalCase", nickname = "createMedicalCaseUsingPOST1", notes = "", response = MedicalCaseDTO.class, tags={ "medical-case-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MedicalCaseDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/medical-cases",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<MedicalCaseDTO> createMedicalCaseUsingPOST1(@ApiParam(value = "medicalCaseDTO" ,required=true )  @Valid @RequestBody MedicalCaseDTO medicalCaseDTO);


    @ApiOperation(value = "deleteMedicalCase", nickname = "deleteMedicalCaseUsingDELETE", notes = "", tags={ "medical-case-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/medical-cases/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMedicalCaseUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllMedicalCases", nickname = "getAllMedicalCasesUsingGET", notes = "", response = MedicalCaseDTO.class, responseContainer = "List", tags={ "medical-case-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MedicalCaseDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/medical-cases",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<MedicalCaseDTO>> getAllMedicalCasesUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getMedicalCase", nickname = "getMedicalCaseUsingGET", notes = "", response = MedicalCaseDTO.class, tags={ "medical-case-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MedicalCaseDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/medical-cases/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<MedicalCaseDTO> getMedicalCaseUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchMedicalCases", nickname = "searchMedicalCasesUsingGET", notes = "", response = MedicalCaseDTO.class, responseContainer = "List", tags={ "medical-case-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MedicalCaseDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/medical-cases",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<MedicalCaseDTO>> searchMedicalCasesUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateMedicalCase", nickname = "updateMedicalCaseUsingPUT", notes = "", response = MedicalCaseDTO.class, tags={ "medical-case-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MedicalCaseDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/medical-cases",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<MedicalCaseDTO> updateMedicalCaseUsingPUT(@ApiParam(value = "medicalCaseDTO" ,required=true )  @Valid @RequestBody MedicalCaseDTO medicalCaseDTO);

}
