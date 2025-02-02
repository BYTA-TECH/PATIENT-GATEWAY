/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.ayoos.client.appointment.api;

import com.bytatech.ayoos.client.appointment.model.AdditionalInformationRequest;
import com.bytatech.ayoos.client.appointment.model.AppointmentConfirmationRequest;
import com.bytatech.ayoos.client.appointment.model.AppointmentConfirmationResponse;
import com.bytatech.ayoos.client.appointment.model.AppointmentDTO;
import com.bytatech.ayoos.client.appointment.model.AppointmentRequest;
import com.bytatech.ayoos.client.appointment.model.CommandResource;
import com.bytatech.ayoos.client.appointment.model.ConsultationDetails;
import com.bytatech.ayoos.client.appointment.model.DoctorInfo;
import com.bytatech.ayoos.client.appointment.model.PatientInfo;
import com.bytatech.ayoos.client.appointment.model.PaymentConfirmationRequest;
import com.bytatech.ayoos.client.appointment.model.ProcessPayment;
import com.bytatech.ayoos.client.appointment.model.Slot;
import com.bytatech.ayoos.client.appointment.model.TaskRequest;
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

@Api(value = "AppointmentCommandResource", description = "the AppointmentCommandResource API")
public interface AppointmentCommandResourceApi {

    @ApiOperation(value = "additionalInformationRequest", nickname = "additionalInformationRequestUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/additionalInformationRequest/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> additionalInformationRequestUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "additionalInformationRequest" ,required=true )  @Valid @RequestBody AdditionalInformationRequest additionalInformationRequest);


    @ApiOperation(value = "chooseDoctor", nickname = "chooseDoctorUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/chooseDoctor/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> chooseDoctorUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "doctorInfo" ,required=true )  @Valid @RequestBody DoctorInfo doctorInfo);


    @ApiOperation(value = "collectAdditionalDetails", nickname = "collectAdditionalDetailsUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/collectAdditionalDetails/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> collectAdditionalDetailsUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "symptomDetails" ,required=true )  @Valid @RequestBody ConsultationDetails consultationDetails);


    @ApiOperation(value = "confirmPayment", nickname = "confirmPaymentUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/confirmPayment/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> confirmPaymentUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "paymentConfirmationRequest" ,required=true )  @Valid @RequestBody PaymentConfirmationRequest paymentConfirmationRequest);


    @ApiOperation(value = "confirmRegistration", nickname = "confirmRegistrationUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/confirmRegistartion/{taskId}",
        produces = "*/*", 
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> confirmRegistrationUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId);


    @ApiOperation(value = "createAppointment", nickname = "createAppointmentUsingPOST", notes = "", response = AppointmentDTO.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AppointmentDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/appointments",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<AppointmentDTO> createAppointmentUsingPOST(@ApiParam(value = "appointmentDTO" ,required=true )  @Valid @RequestBody AppointmentDTO appointmentDTO);


    @ApiOperation(value = "deleteAppointment", nickname = "deleteAppointmentUsingDELETE", notes = "", tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/command/appointments/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAppointmentUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "initiateAppointment", nickname = "initiateAppointmentUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/initiateAppointment",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> initiateAppointmentUsingPOST(@ApiParam(value = "appointementRequest" ,required=true )  @Valid @RequestBody AppointmentRequest appointmentRequest);


    @ApiOperation(value = "processAppointmentRequest", nickname = "processAppointmentRequestUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/processAppointmentRequest/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> processAppointmentRequestUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "appointmentConfirmationResponse" ,required=true )  @Valid @RequestBody AppointmentConfirmationResponse appointmentConfirmationResponse);


    @ApiOperation(value = "processPayment", nickname = "processPaymentUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/processPayment/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> processPaymentUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "processPayment" ,required=true )  @Valid @RequestBody ProcessPayment processPayment);


    @ApiOperation(value = "publishMessageToKafka", nickname = "publishMessageToKafkaUsingPOST", notes = "", response = Boolean.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Boolean.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/publishAppointment",
        produces = "*/*", 
        method = RequestMethod.POST)
    ResponseEntity<Boolean> publishMessageToKafkaUsingPOST();


    @ApiOperation(value = "selectSlot", nickname = "selectSlotUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/chooseSlot/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> selectSlotUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "slotSelectionRequest" ,required=true )  @Valid @RequestBody Slot slot);


    @ApiOperation(value = "sendAppointmentRequest", nickname = "sendAppointmentRequestUsingPOST", notes = "", response = CommandResource.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommandResource.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/sendAppointmentRequest/{taskId}",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommandResource> sendAppointmentRequestUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "appointmentConfirmationRequest" ,required=true )  @Valid @RequestBody AppointmentConfirmationRequest appointmentConfirmationRequest);


    @ApiOperation(value = "updateAppointment", nickname = "updateAppointmentUsingPUT", notes = "", response = AppointmentDTO.class, tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AppointmentDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/appointments",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<AppointmentDTO> updateAppointmentUsingPUT(@ApiParam(value = "appointmentDTO" ,required=true )  @Valid @RequestBody AppointmentDTO appointmentDTO);


    @ApiOperation(value = "updatePatientInfo", nickname = "updatePatientInfoUsingPUT", notes = "", tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/updatePatientInfo/{processInstanceId}",
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePatientInfoUsingPUT(@ApiParam(value = "processInstanceId",required=true) @PathVariable("processInstanceId") String processInstanceId,@ApiParam(value = "patientInfo" ,required=true )  @Valid @RequestBody PatientInfo patientInfo);


    @ApiOperation(value = "updateTask", nickname = "updateTaskUsingPUT", notes = "", tags={ "appointment-command-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/command/updateTask/{taskId}",
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTaskUsingPUT(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") String taskId,@ApiParam(value = "taskRequest" ,required=true )  @Valid @RequestBody TaskRequest taskRequest);

}
