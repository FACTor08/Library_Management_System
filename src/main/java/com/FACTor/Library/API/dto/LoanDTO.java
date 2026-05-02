package com.FACTor.Library.API.dto;

import com.FACTor.Library.API.entity.Books;
import com.FACTor.Library.API.entity.Status;
import com.FACTor.Library.API.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoanDTO {
    private String libraryId;
    private String bookTitle;
   }
