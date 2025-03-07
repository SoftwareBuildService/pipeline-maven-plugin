/*
 * The MIT License
 *
 * Copyright (c) 2016, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.pipeline.maven.eventspy.handler;

import java.util.Arrays;
import java.util.List;

import org.apache.maven.execution.ExecutionEvent;
import org.jenkinsci.plugins.pipeline.maven.eventspy.reporter.MavenEventReporter;

import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;

/**
 * @author <a href="mailto:cleclerc@cloudbees.com">Cyrille Le Clerc</a>
 */
public class FailsafeTestExecutionHandler extends AbstractExecutionHandler {

    public FailsafeTestExecutionHandler(MavenEventReporter reporter) {
        super(reporter);
    }

    @Nullable
    protected ExecutionEvent.Type getSupportedType() {
        return ExecutionEvent.Type.MojoSucceeded;
    }

    @Nullable
    @Override
    protected String getSupportedPluginGoal() {
        return "org.apache.maven.plugins:maven-failsafe-plugin:integration-test";
    }

    @NonNull
    @Override
    protected List<String> getConfigurationParametersToReport(ExecutionEvent executionEvent) {
        return Arrays.asList("reportsDirectory", "systemPropertyVariables");
    }
}
