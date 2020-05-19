package com.bhuwan.components;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

@Import(stylesheet =
        {"context:/assets/css/materialize.css",
                "context:/assets/css/materialize.min.css",
                "context:/assets/js/materialize.js",
                "context:/assets/js/materialize.min.js"
        })
public class Layout {

    @Inject
    private Messages messages;

    public String getApplicationTitle() {
        return messages.get("application-title");
    }

}
