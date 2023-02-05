# git SSH 적용기

## SSH란

Secure Shell
로컬컴퓨터에서 만든 ssh public key를 원격컴퓨터에 저장을 해두면
원격저장소를 접근할때 별다른 로그인 없이 접근이 가능하다.

### Step1 SSH KEY 생성

로컬컴퓨터에서
`ssh-keygen` 명령어를 터미널에 입력후 id_rsa id_rsa.pub 생성
비밀번호를 등록하는 것을 권장한다.

`cat id_rsa.pub` cat명령어를 사용하면 파일내용을 출력해준다.

### Step2 SSH KEY 등록

사용하려는 원격컴퓨터 or 원격저장소(github)에 SSH KEY를 등록한다.
git hub에 new SSH KEY를 이용하여 생성해두었던 public key (id_rsa.pub)를 가져와 입력해준다.
그냥 복사해도 되지만 clip명령어를 이용하면 좀 더 정확한 복사가 가능하다.
`clip < ~/.ssh/id_rsa.pub`
