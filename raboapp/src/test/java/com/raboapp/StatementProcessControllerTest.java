package com.raboapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes=RaboApp.class)
@AutoConfigureMockMvc
public class StatementProcessControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void readXMLDocAndFindInvalidateResord() throws Exception{
		
		   String xml="<records><record reference='187997'><accountNumber>NL91RABO0315273637</accountNumber><description>Clothes for Rik King</description><startBalance>57.6</startBalance><mutation>-32.98</mutation><endBalance>24.62</endBalance></record><record reference='187997'><accountNumber>NL91RABO0315273637</accountNumber><description>Clothes for Rik King</description><startBalance>57.6</startBalance><mutation>-32.98</mutation><endBalance>24.62</endBalance></record></records>";
		   String fileName = "report.xml";
		   
		   MockMultipartFile mockMultipartFile = new MockMultipartFile("report", fileName, "application/xml", xml.getBytes());
	       
		   MvcResult result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/raboapp/stmtprocessor/validateStatement").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
	               .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
		   assertEquals(200, result.getResponse().getStatus());
              
	}
	
	@Test
	public void testToUploadInvalidFileTye() throws Exception{
		
		   String xml="Test  PDF";
		   String fileName = "report.pdf";
		   
		   MockMultipartFile mockMultipartFile = new MockMultipartFile("report", fileName, "application/pdf", xml.getBytes());
	       
		   MvcResult result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/raboapp/stmtprocessor/validateStatement").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
	               .andExpect(MockMvcResultMatchers.status().is(415)).andReturn();
		   assertEquals(415, result.getResponse().getStatus());
            
	}
	

}
