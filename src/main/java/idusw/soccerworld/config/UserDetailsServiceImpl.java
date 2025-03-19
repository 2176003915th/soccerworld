//package idusw.soccerworld.config;
//
//import idusw.soccerworld.domain.dto.MemberDto;
//import idusw.soccerworld.service.MemberService;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    final MemberService memberService;
//    public UserDetailsServiceImpl(MemberServicea memberService) {
//        this.memberService = memberService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        MemberDto memberDto = memberService.checkLogin(username);
//        if (memberDto == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return memberDto;
//    }
//}
