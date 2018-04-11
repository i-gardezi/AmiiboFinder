package gardezi.io.amiibofinder.dagger

import dagger.Subcomponent
import gardezi.io.amiibofinder.viewmodel.AmiiboViewModel

@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun amiiboViewModel(): AmiiboViewModel
}
