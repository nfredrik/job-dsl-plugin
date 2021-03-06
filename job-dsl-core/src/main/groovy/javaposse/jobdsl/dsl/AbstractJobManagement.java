package javaposse.jobdsl.dsl;

import com.google.common.collect.Maps;

import java.io.PrintStream;
import java.util.Map;

/**
 * Abstract version of JobManagement to minimize impact on future API changes
 */
public abstract class AbstractJobManagement implements JobManagement {
    protected PrintStream out;

    protected AbstractJobManagement(PrintStream out) {
        this.out = out;
    }

    protected AbstractJobManagement() {
        this(System.out);
    }

    @Override
    public PrintStream getOutputStream() {
        return out;
    }

    /**
     * Map if variables that should be available to the script.
     */
     @Override
     public Map<String, String> getParameters() {
        return Maps.newHashMap();
    }

    protected void validateUpdateArgs(String jobName, String config) {
        if (jobName == null || jobName.isEmpty()) throw new JobNameNotProvidedException();
        if (config == null || config.isEmpty()) throw new JobConfigurationMissingException();
    }

}
