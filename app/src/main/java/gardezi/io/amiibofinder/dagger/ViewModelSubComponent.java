package gardezi.io.amiibofinder.dagger;

import dagger.Component;
import dagger.Subcomponent;
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    AmiiboViewModel amiiboViewModel();
}
