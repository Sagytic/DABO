<template>
    <div>
        <div class="dabo_header">
            <h2 class="dabo_title">헌혈의 집 예약 내역</h2>
        </div>
        <div class="reservationHistory-page">
            <div class="img_com">
                    <img src="@/assets/imoge.png" class="imoge_com"/>
                <p class="img_p">예약이 접수되었습니다!
                <br /> 잠시후 확정 전화가 올 때까지 대기하여 주세요.</p>
            </div>
            <div>
                <h4 class="r_h4">나의 예약 현황</h4>
                <div class="reservationList">
                    <p><b>헌혈의 집 {{ reservation.housename }}</b></p>
                    <b>주소</b>
                    <p>{{ reservation.address }}</p>
                    <b>전화번호</b>
                    <p>{{ reservation.telephone}}</p>
                    <b>예약 날짜</b>
                    <p>{{ reservation.bloodDate}} {{ reservation.bloodTime }}</p>
                    <b>헌혈 종류</b>
                    <p>{{ reservation.bloodType }} 헌혈</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            reservation: [],
        }
    },
    async created() {
        this.reservation = this.$route.params.reservation;
        console.log(this.reservation);
    }
}
</script>

<style>
.reservationHistory-page {
    margin: 0 auto;
    width: 85%;
}
.reservationList {
    padding: 7px;
    border-radius: 5px;
    box-shadow: 2px 2px 2px 2px rgb(190, 190, 190);
}
.img_com {
    height: 280px;
    text-align: center;
}
.imoge_com {
    width: 130px;
    height: 130px;
    margin-top: 50px;
}
.img_p {
    margin-top: 10px;
    margin-bottom: 30px;
}
.r_h4 {
    color: #e52d27;
    font-weight: bold;
}
</style>