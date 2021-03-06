/*
 * Copyright 2011 JBoss Inc 
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
package org.jbpm.console.ng.client.fb.view.canvas;


import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import org.jbpm.form.builder.ng.model.client.form.FBForm;

public interface CanvasView extends IsWidget {

    FBForm getFormDisplay();

    void startDropController(PickupDragController controller, IsWidget widget);
    
    HasWidgets getUnderlyingLayout(Integer x, Integer y);
}
