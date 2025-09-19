package com.duende.cicero_app.service.interfaces.feat;

import com.duende.cicero_app.model.FeatModel;
import com.duende.cicero_app.model.infected.InfectedModel;

public interface FeatApplier {

    boolean supports(FeatModel feat);
    void apply(InfectedModel infected, FeatModel feat, Long targetId);

}
