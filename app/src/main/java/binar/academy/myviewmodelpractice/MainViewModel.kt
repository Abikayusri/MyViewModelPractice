package binar.academy.myviewmodelpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Abika Chairul Yusri created on 3/3/2022 at 12:24 PM.
 */
// TODO 5: Buat sebuah class viewModel dengan function lengkap
class MainViewModel : ViewModel() {
    val vCounnter: MutableLiveData<Int> = MutableLiveData(0)

    fun incrementCount() {
        vCounnter.postValue(vCounnter.value?.plus(1))
    }

    fun decrementCount() {
        vCounnter.value?.let {
            if (it > 0) {
                vCounnter.postValue(vCounnter.value?.minus(1))
            }
        }
    }
}