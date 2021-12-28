/*
 * Copyright (c) 2020 Giorgio Antonioli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.kpermissions.extension

import android.Manifest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fondesa.kpermissions.testing.context
import com.fondesa.kpermissions.testing.denyPermissions
import com.fondesa.kpermissions.testing.grantPermissions
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests for IsPermissionGranted.kt file.
 */
@RunWith(AndroidJUnit4::class)
class IsPermissionGrantedKtTest {

    @Test
    fun isPermissionGrantedOrDenied() {
        val grantedPermission = Manifest.permission.SEND_SMS
        val deniedPermission = Manifest.permission.ACCESS_FINE_LOCATION

        context.grantPermissions(grantedPermission)
        context.denyPermissions(deniedPermission)

        val grantedResult = context.isPermissionGranted(grantedPermission)
        assertEquals(true, grantedResult)

        val deniedResult = context.isPermissionGranted(deniedPermission)
        assertEquals(false, deniedResult)
    }
}
