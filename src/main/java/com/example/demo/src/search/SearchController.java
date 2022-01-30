package com.example.demo.src.search;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.search.model.*;
import com.example.demo.src.store.model.GetStoreRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/search")

public class SearchController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SearchProvider searchProvider;
    private final SearchService searchService;
    private final JwtService jwtService;

    @Autowired
    public SearchController(SearchProvider searchProvider, SearchService searchService, JwtService jwtService) {
        this.searchProvider = searchProvider;
        this.searchService = searchService;
        this.jwtService = jwtService;
    }

    // ************************************************************************************

    // 유저가 저장한 식당 검색 By 식당 이름, 해시태그
    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<GetSearchRes> getSearch(@PathVariable("userIdx") int userIdx, @RequestParam("keyword") String keyword) {
        try {
            int userIdxByJwt = jwtService.getUserIdx();

            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            GetSearchRes getSearchRes = searchProvider.getSearch(userIdx, keyword);

            return new BaseResponse<>(getSearchRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    // 검색한 해시태그 클릭 시 해당 해시태그를 가진 식당들의 정보 조회
    @ResponseBody
    @GetMapping("/{userIdx}/hashtag")
    public BaseResponse<List<GetStoreRes>> getStoresByHashTag(@PathVariable("userIdx") int userIdx, @RequestParam("tagIdx") int tagIdx, @RequestParam(defaultValue = "1") int page, @RequestParam int pageSize) {
        try {
            int userIdxByJwt = jwtService.getUserIdx();

            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }

            List<GetStoreRes> getStoreRes = searchProvider.getStoresByHashtag(userIdx, tagIdx, page, pageSize);

            return new BaseResponse<>(getStoreRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}