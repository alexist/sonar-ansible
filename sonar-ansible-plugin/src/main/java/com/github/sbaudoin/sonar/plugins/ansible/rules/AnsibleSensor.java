/**
 * Copyright (c) 2018-2021, Sylvain Baudoin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sbaudoin.sonar.plugins.ansible.rules;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import com.github.sbaudoin.sonar.plugins.yaml.languages.YamlLanguage;

public class AnsibleSensor extends AbstractAnsibleSensor {
    /**
     * Constructor
     *
     * @param fileSystem the file system on which the sensor will find the files to be analyzed
     */
    public AnsibleSensor(FileSystem fileSystem) {
        super(fileSystem);
    }


    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.onlyOnLanguage(YamlLanguage.KEY);
        descriptor.name("Ansible Lint Sensor");
    }

    @Override
    public void execute(SensorContext context) {
        executeWithAnsibleLint(context, null);
    }
}
