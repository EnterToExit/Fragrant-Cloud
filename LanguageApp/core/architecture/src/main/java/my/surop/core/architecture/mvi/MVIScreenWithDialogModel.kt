package my.surop.core.architecture.mvi

import my.surop.core.architecture.mvi.models.DialogStateModel
import my.surop.core.architecture.mvi.models.MVIConfiguration
import my.surop.core.architecture.mvi.models.dialogStateModel


@Suppress("UnnecessaryAbstractClass")
abstract class MVIScreenWithDialogModel<E, S, A, D>(
    config: MVIConfiguration<S>
) : MVIScreenModel<E, S, A>(config),
    DialogStateModel<D?> by dialogStateModel()
