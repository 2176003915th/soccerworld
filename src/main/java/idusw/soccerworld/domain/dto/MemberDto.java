package idusw.soccerworld.domain.dto;

import idusw.soccerworld.domain.entity.MemberEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class MemberDto implements UserDetails {
    private long memberId;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

//    public MemberDto (MemberEntity memberEntity) {
//        this.memberId = memberEntity.getMemberId();
//        this.username = memberEntity.getId();
//        this.password = memberEntity.getPassword();
//        this.authorities = new ArrayList<>();
//        this.authorities.add(new SimpleGrantedAuthority("USER"));
//    }

    public static MemberDto entityToDto(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(memberEntity.getMemberId());
        memberDto.setUsername(memberEntity.getId());
        memberDto.setPassword(memberEntity.getPassword());
        memberDto.setAuthorities(new ArrayList<>());
        memberDto.authorities.add(new SimpleGrantedAuthority("USER"));

        return memberDto;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠금 여부
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호 만료 여부
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성 여부
    }
}
