import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "landing",
    component: () => import(/* webpackChunkName: "landing" */ "@/views/landing/landingPage.vue"),
  },
  {
    path: "/home",
    name: "home",
    component: () => import(/* webpackChunkName: "home" */ "@/views/mainPage.vue"),
  },
  {
    path: "/user",
    name: "user",
    component: () => import(/* webpackChunkName: "user" */ "@/views/user/userPage.vue"),
    children: [
      {
        path: "login",
        name: "login",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/loginPage.vue"),
      },
      {
        path: "signup",
        name: "signup",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/signUp.vue"),
      },
      {
        path: "findpassword",
        name: "findpassword",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/findPassword.vue"),
      },
      {
        path: "infochange",
        name: "infoChange",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/infoChange.vue"),
      },
      {
        path: "ranking",
        name: "ranking",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/rankingDetail.vue"),
      },
    ],
  },

  {
    path: "/reservation",
    name: "reservation",
    component: () => import(/* webpackChunkName: "reservation" */ "@/views/reservation/reservationMain.vue"),
    children: [
      {
        path: "bloodHouseList",
        name: "bloodHouseList",
        component: () => import(/* webpackChunkName: "reservation" */ "@/components/reservation/bloodHouseList.vue"),
      },
      {
        path: "nowReservation",
        name: "nowReservation",
        component: () => import(/* webpackChunkName: "reservation" */ "@/components/reservation/nowReservation.vue"),
      },
      {
        path: "reservationHistory",
        name: "reservationHistory",
        component: () => import(/* webpackChunkName: "reservation" */ "@/components/reservation/reservationHistory.vue"),
      },
    ],
  },
  {
    path: "/donationBoard",
    name: "donationBoard",
    component: () => import(/* webpackChunkName: "donationBoard" */ "@/views/donationBoard/donationBoardPage.vue"),
    children: [
      {
        path: "listBoard",
        name: "listBoard",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardList.vue"),
      },
      {
        path: "listItem",
        name: "listItem",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardListItem.vue"),
      },
      {
        path: "createBoard",
        name: "createBoard",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardCreate.vue"),
      },
      {
        path: "updateBoard",
        name: "updateBoard",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardUpdate.vue"),
      },
      {
        path: "detailBoard/:campaignId",
        name: "detailBoard",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardDetail.vue"),
      },
      {
        path: "myDonation",
        name: "myDonation",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/bloodCardDonation.vue"),
      },
      {
        path: "donationConfirm",
        name: "donationConfirm",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationConfirm.vue"),
      },
      {
        path: "daboDonation",
        name: "daboDonation",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/daboDonation.vue"),
      },
      {
        path: "daboConfirm",
        name: "daboConfirm",
        component: () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/daboConfirm.vue"),
      },
    ],
  },
  {
    path: "/dabowallet",
    name: "daboWallet",
    component: () => import(/* webpackChunkName: "daboWallet" */ "@/views/daboWallet/daboWalletMain.vue"),
    // children: [
    //   {
    //     path: "/chargedabo",
    //     name: "chargedabo",
    //     component: chargeDabo,
    //   },
    // ]
  },
  {
    path: "/testDabo",
    name: "testDabo",
    component: () => import(/* webpackChunkName: "testDabo" */ "@/components/wallet/testDabo.vue"),
  },
  {
    path: "/dabowallet/chargedabo",
    name: "chargedabo",
    component: () => import(/* webpackChunkName: "daboWallet" */ "@/views/daboWallet/chargeDabo.vue"),
  },
  {
    path: "/dabowallet/paydabo",
    name: "paydabo",
    component: () => import(/* webpackChunkName: "daboWallet" */ "@/views/daboWallet/payDabo.vue"),
  },
  {
    path: "/dabowallet/chargeconfirm",
    name: "chargeconfirm",
    component: () => import(/* webpackChunkName: "daboWallet" */ "@/views/daboWallet/chargeConfirm.vue"),
  },
  {
    path: "/bloodcard",
    name: "bloodCard",
    component: () => import(/* webpackChunkName: "bloodCard" */ "@/views/bloodCard/bloodCard.vue"),
    children: [
      {
        path: "list",
        name: "bloodcardList",
        component: () => import(/* webpackChunkName: "bloodCard" */ "@/components/bloodcard/bloodcardList.vue"),
      },
      {
        path: "create",
        name: "bloodcardCreate",
        component: () => import(/* webpackChunkName: "bloodCard" */ "@/components/bloodcard/bloodcardCreate.vue"),
      },
    ],
  },
  {
    path: "/badge",
    name: "badge",
    component: () => import(/* webpackChunkName: "badge" */ "@/views/badge/badgeMain.vue"),
  },
  {
    path: "/mydabo",
    name: "myDabo",
    component: () => import(/* webpackChunkName: "user" */ "@/views/user/myDabo.vue"),
  },
  {
    name: "exBlockChain",
    path: "/exBlockChain",
    component: () => import(/* webpackChunkName: "exBlockChain" */ "@/views/exBlockChain.vue"),
    children: [
      {
        name: "exBlockChain.dashboard",
        path: "dashboard",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/Dashboard.vue"),
      },
      {
        name: "exBlockChain.block",
        path: "blocks",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/BlockListView.vue"),
      },
      {
        name: "exBlockChain.block.detail",
        path: "block/:blockNumber",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/BlockDetail.vue"),
      },
      {
        name: "exBlockChain.tx",
        path: "txes",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/TxListView.vue"),
      },
      {
        name: "exBlockChain.tx.detail",
        path: "tx/:hash",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/TxDetail.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
