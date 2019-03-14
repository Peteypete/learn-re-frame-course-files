(ns app.nav.views.nav-item
  (:require ["@smooth-ui/core-sc" :refer [Box]]))

(defn nav-item
  [{:keys [id href name dispatch active-nav]}]
  [:> Box {:key id
           :as "a"
           :href href
           :on-click dispatch ; gets replaced w :dispatch contentofdispatch
           :ml 2
           :pb 10
           :border-bottom (when (= active-nav id) "2px solid #102A43")}
   name])

;This is the template of what I draw


[:on-click dispatch  :dispatch dispatch :dispatch #(rf/dispatch [:set-active-nav :inboxes])] ---->  [:on-click #(rf/dispatch [:set-active-nav :inboxes])]

[:on-click dispatch  :dispatch dispatch :dispatch #(rf/dispatch [:set-active-nav :inboxes])] ---->  [:on-click #(rf/dispatch [:set-active-nav :inboxes])]

[:href href :href href :href "#saved"] ---->  [:href "#saved"]
