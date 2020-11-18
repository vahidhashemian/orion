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
package com.pinterest.orion.core.actions.kafka;

import com.pinterest.orion.core.actions.Action;
import com.pinterest.orion.core.actions.generic.DemoAction;

public class ConcurrentKafkaTestAction extends ConcurrentKafkaAction {

  public ConcurrentKafkaTestAction() {
    super("concurrenttest");
  }

  @Override
  protected Action getChildAction() {
    return new DemoAction();
  }

  @Override
  public boolean failIfNoNodeIds() {
    return false;
  }
}
