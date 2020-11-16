/*******************************************************************************
 * Copyright 2020 Pinterest, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.pinterest.orion.agent.kafka;

import com.pinterest.orion.agent.metrics.MetricValue;

import java.util.concurrent.Callable;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

public class KafkaMetricRetrievingTask implements Callable<MetricValue> {

  private MBeanServerConnection mbs;
  private String metricName;
  private String attributeName;

  public KafkaMetricRetrievingTask(MBeanServerConnection mbs,
                                   String metricName,
                                   String attributeName) {
    this.mbs = mbs;
    this.metricName = metricName;
    this.attributeName = attributeName;
  }

  @Override
  public MetricValue call() throws Exception {
    try {
      Object obj = mbs.getAttribute(new ObjectName(metricName), attributeName);
      return new MetricValue(obj);
    } catch (Exception e) {
      return new MetricValue(e);
    }
  }
}
