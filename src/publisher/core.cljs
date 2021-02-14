(ns publisher.core
  (:require [reagent.dom :as rdom]
            [publisher.layout :as layout]
            [publisher.login]))

(defn ^:export main []
  (rdom/render
    [layout/app]
    (.getElementById js/document "app")))
