<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  ~ Copyright 2012 JBoss Inc
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~       http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
        <!-- before your module(*.nocache.js) loading  -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <!--[if IE 7]>
        <link rel="stylesheet" href="{your module name}/css/font-awesome-ie7.css">
        <![endif]-->
        <!-- your module(*.nocache.js) loading  -->
        <!--
             Note you can append #asset=UUID to the end of the URL to preload a given asset.
             Also, if you append #asset=UUID&nochrome it will only show the asset without all the GUI "chrome"
        -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="gwt:property" content="locale=<%=request.getLocale().toString()%>">

        <title>JBoss jBPM Console</title>
        <link rel="shortcut icon" href="images/drools.gif" type="image/gif"/>
        <link rel="icon" href="images/drools.gif" type="image/gif"/>

        <link rel="stylesheet" href="css/uberfire-workbench.css">
        <link rel="stylesheet" href="css/uberfire-showcase.css">
        <link rel="stylesheet" href="css/ruleflow.css">
    </head>
    <body>
        <iframe id="__gwt_historyFrame" style="width: 0; height: 0; border: 0"></iframe>

        <!--add loading indicator while the app is being loaded-->
        <div id="loading">
            <div class="loading-indicator">
                <img src="images/loading-icon.gif" width="32" height="32" style="margin-right: 8px; float: left; vertical-align: top;"/>
                Please wait<br/> <span id="loading-msg">Loading application...</span>
            </div>
        </div>

        <!-- The GWT js file generated at run time -->
        <script type="text/javascript" src='org.jbpm.console.ng.jBPMShowcase.nocache.js'></script>

    </body>
</html>
