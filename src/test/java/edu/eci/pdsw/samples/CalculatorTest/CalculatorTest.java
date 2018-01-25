/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.CalculatorTest;

import edu.eci.pdsw.util.Pair;
import edu.eci.pdsw.commandpattern_testing.CalculadoraTarifas;
import edu.eci.pdsw.commandpattern_testing.ExcepcionParametrosInvalidos;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;

public class CalculatorTest {

/*    
    @Test
    public void testClaseEquivUno() throws Exception{
        CalculadoraTarifas ct=new CalculadoraTarifas();
        Assert.assertEquals("Se esta modificando el valor de la tarifa en un caso en el que no aplica ningun descuento.",new Float(1000),new Float(ct.calculoTarifa(1000, new DateTime(2015, 1, 20, 0, 0), new DateTime(2015, 1, 20, 0, 0), 30)));
        
    }
*/

    private DateTime now;
    private float tarifa;

    @Before
    public void init() {
        now = new DateTime();
        tarifa = 1000f;
    }


    @Test
    public void testClaseEquivalenciaUno() {
        CalculadoraTarifas ct=new CalculadoraTarifas();

        qt().forAll(range(0,17),range(0,20))
            .check((edad,days) -> ct.calculoTarifa(tarifa,now, now.minus(days),edad) == tarifa * (1 - 0.05));
    }

}
