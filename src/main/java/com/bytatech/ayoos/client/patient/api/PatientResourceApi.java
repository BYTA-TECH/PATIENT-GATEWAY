/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.ayoos.client.patient.api;

import com.bytatech.ayoos.client.patient.model.Patient;
import com.bytatech.ayoos.client.patient.model.PatientDTO;
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

@Api(value = "PatientResource", description = "the PatientResource API")
public interface PatientResourceApi {

    @ApiOperation(value = "createPatient", nickname = "createPatientUsingPOST1", notes = "", response = PatientDTO.class, tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PatientDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/patients",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<PatientDTO> createPatientUsingPOST1(@ApiParam(value = "patientDTO" ,required=true )  @Valid @RequestBody PatientDTO patientDTO);


    @ApiOperation(value = "deletePatient", nickname = "deletePatientUsingDELETE", notes = "", tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/patients/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePatientUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllPatients", nickname = "getAllPatientsUsingGET", notes = "", response = PatientDTO.class, responseContainer = "List", tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PatientDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/patients",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<PatientDTO>> getAllPatientsUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getPatient", nickname = "getPatientUsingGET", notes = "", response = PatientDTO.class, tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PatientDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/patients/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<PatientDTO> getPatientUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "modelToDto", nickname = "modelToDtoUsingPOST", notes = "", response = PatientDTO.class, tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PatientDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/patients/modelToDto",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<PatientDTO> modelToDtoUsingPOST(@ApiParam(value = "patient" ,required=true )  @Valid @RequestBody Patient patient);


    @ApiOperation(value = "searchPatients", nickname = "searchPatientsUsingGET", notes = "", response = PatientDTO.class, responseContainer = "List", tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PatientDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/patients",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<PatientDTO>> searchPatientsUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updatePatient", nickname = "updatePatientUsingPUT1", notes = "", response = PatientDTO.class, tags={ "patient-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PatientDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/patients",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<PatientDTO> updatePatientUsingPUT1(@ApiParam(value = "patientDTO" ,required=true )  @Valid @RequestBody PatientDTO patientDTO);

}
