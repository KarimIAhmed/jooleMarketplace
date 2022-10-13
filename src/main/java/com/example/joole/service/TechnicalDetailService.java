package com.example.joole.service;

import com.example.joole.model.Project;
import com.example.joole.model.TechnicalDetail;

import java.util.List;

public interface TechnicalDetailService {
    TechnicalDetail createTechnicalDetail(TechnicalDetail technicalDetail);
    List<TechnicalDetail> findTechnicalDetail();
    TechnicalDetail findTechnicalDetailById(long Id);
    String deleteTechnicalDetail(long id);
}
