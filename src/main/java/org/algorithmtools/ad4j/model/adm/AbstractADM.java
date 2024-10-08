package org.algorithmtools.ad4j.model.adm;

import org.algorithmtools.ad4j.enumtype.AnomalyDictType;
import org.algorithmtools.ad4j.pojo.AnomalyDetectionContext;
import org.algorithmtools.ad4j.pojo.AnomalyDetectionLog;
import org.algorithmtools.ad4j.pojo.IndicatorEvaluateInfo;
import org.algorithmtools.ad4j.pojo.IndicatorSeries;

import java.util.List;

/**
 * Anomaly detection model abstract interface
 * @author mym
 */
public abstract class AbstractADM {

    /**
     * model name
     */
    protected AnomalyDictType anomalyDetectionModel;

    /**
     * anomaly type
     */
    protected AnomalyDictType anomalyType;

    public AbstractADM(AnomalyDictType anomalyDetectionModel, AnomalyDictType anomalyType) {
        this.anomalyDetectionModel = anomalyDetectionModel;
        this.anomalyType = anomalyType;
    }

    /**
     * init model
     * @param context context env
     */
    public abstract void init(AnomalyDetectionContext context);

    /**
     * evaluate anomaly
     * @param indicatorSeries indicator series
     * @param log log
     */
    public abstract IndicatorEvaluateInfo evaluate(List<IndicatorSeries> indicatorSeries, AnomalyDetectionLog log);

    /**
     * check compatibility
     * @param indicatorSeries indicator series
     * @param log log
     * @return boolean true/false
     */
    public abstract boolean checkCompatibility(List<IndicatorSeries> indicatorSeries, AnomalyDetectionLog log);

    public IndicatorEvaluateInfo buildDefaultEvaluateInfo(){
        return new IndicatorEvaluateInfo(anomalyDetectionModel, anomalyType, false);
    }

    public AnomalyDictType getAnomalyDetectionModel() {
        return anomalyDetectionModel;
    }

    public AnomalyDictType getAnomalyType() {
        return anomalyType;
    }

}
