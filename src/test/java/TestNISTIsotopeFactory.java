/*
 * NCATS-MOLWITCH
 *
 * Copyright 2025 NIH/NCATS
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import gov.nih.ncats.molwitch.isotopes.NISTIsotopeFactory;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestNISTIsotopeFactory {

    @Test
    public void tableRead(){
        assertNotNull(NISTIsotopeFactory.INSTANCE.getIsotopesFor("F"));

        assertNotNull(NISTIsotopeFactory.INSTANCE.getIsotopesFor("C"));

        assertNull(NISTIsotopeFactory.INSTANCE.getIsotopesFor("J"));
    }
}
