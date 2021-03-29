package com.bobo.SpringAndAWS.web;

import com.bobo.SpringAndAWS.config.auth.LoginUser;
import com.bobo.SpringAndAWS.config.auth.dto.SessionUser;
import com.bobo.SpringAndAWS.service.posts.PostsService;
import com.bobo.SpringAndAWS.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    /*
    * Model --> 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
    * 여기서는 postsService.finAllDesc()로 가져온 결과를 posts로 index.mustache애 전달*/
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // @LoginUser만 사용하면 세션 정보를 가져올 수 있음
        model.addAttribute("posts", postsService.findAllDesc());

        /*메소드 외에 다른 컨트롤러와 메소드에서 세션값이 필요하면 그때마다 직접 세션에서 값을 가져와야 함
        * 같은 코드가 계속해서 반복되는 것은 불필요, 이 부분을 메소드 인자로 세션값을 받을수 있도록 변경하면 good
        SessionUser user = (SessionUser) httpSession.getAttribute("user");*/


        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
