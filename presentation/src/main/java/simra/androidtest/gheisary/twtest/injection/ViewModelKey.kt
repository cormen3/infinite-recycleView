package simra.androidtest.gheisary.twtest.injection

import dagger.MapKey
import java.lang.annotation.RetentionPolicy
import android.arch.lifecycle.ViewModel
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)