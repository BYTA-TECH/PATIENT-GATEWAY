package com.bytatech.ayoos.client.patient.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.bytatech.ayoos.client.patient.PatientClientConfiguration;

@FeignClient(name="${patient.name:patient}", url="${patient.url:35.238.35.19:8099/}", configuration = PatientClientConfiguration.class)
public interface CommandResourceApiClient extends CommandResourceApi {
}