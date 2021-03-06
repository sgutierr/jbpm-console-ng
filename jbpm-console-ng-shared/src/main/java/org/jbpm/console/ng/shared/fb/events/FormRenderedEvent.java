/*
 * Copyright 2012 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.console.ng.shared.fb.events;

import org.jboss.errai.common.client.api.annotations.Portable;

/**
 *
 */
@Portable
public class FormRenderedEvent {
    private String form;

    public FormRenderedEvent() {
    }

    
    public FormRenderedEvent(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }
    
    
}
