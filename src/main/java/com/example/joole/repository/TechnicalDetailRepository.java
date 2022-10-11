package com.example.joole.repository;

import com.example.joole.model.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetail,Long> {

    Optional<List<TechnicalDetail>> findByAirflow(int airFlow);
    Optional<List<TechnicalDetail>> findByPower(int power);
    Optional<List<TechnicalDetail>> findByOperatingVoltage(int operatingVoltage);
    Optional<List<TechnicalDetail>> findByFanSpeed(int fanSpeed);
}
