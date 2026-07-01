# UI_GUIDELINES_JA

Tier: 1 (Constitution)
Status: Stable
Depends On:
- DESIGN_PHILOSOPHY.md
- DOCS_RULES.md

---

# 目的

この文書は、EconomiCraft における公式UI設計方針および操作ルールを定義します。

Tier 2 以下のすべての文書は、本ガイドラインに従わなければなりません。

例:

- BANK.md
- SHOP.md
- AUCTION.md
- TEAM.md
- MENU.md
- NPC.md

下位Tierの文書は、本書の内容を上書きしてはなりません。

---

# 1. 設計思想

EconomiCraft は以下の原則に従います。

- Vanilla Extension First
- 没入感を壊さない利便性
- Chest GUI First
- Minecraftらしい操作感
- Hypixel SkyBlockを参考にするが再現はしない
- Resource Pack Friendly
- Addon Extensible

目標は、外部アプリケーションのような体験ではなく、Minecraftを自然に拡張したように感じられることです。

---

# 2. GUI標準

## 2.1 基本インターフェース

主要なUIシステム:

- Chest GUI

補助インターフェース:

- Sign GUI

チャット入力によるUIは、可能な限り使用しないものとします。

---

## 2.2 GUIサイズ方針

標準サイズ:

- 54スロット（6行）

縮小可能サイズ:

- 27スロット
- 18スロット
- 9スロット

ルール:

- ページ送りより階層化を優先する。
- ページ送りは最終手段とする。
- 大規模システムはカテゴリ分割を基本とする。

---

# 3. ナビゲーションルール

## 3.1 Backボタン

基本配置:

- 右下付近

ルール:

- Closeボタンと隣接させない。
- 可能な限り1マス以上離す。
- レイアウト上必要であれば位置調整を許可する。

---

## 3.2 Closeボタン

基本配置:

- 右下付近

ルール:

- Backボタンと明確に区別する。
- 誤クリックを防止する。

---

## 3.3 キャンセル操作

キャンセル時は、意味のある親画面へ戻す。

例:

- 出品作成 → Listings画面
- 入金額選択 → Deposit画面

長い操作フローでは、一段ずつ戻る方式を避ける。

---

# 4. 検索システム

標準アイコン:

- コンパス

操作:

左クリック:

- Sign GUI を開く

右クリック:

- 全件表示

ルール:

- 空文字入力はキャンセル扱い。
- 検索結果は軽量に保つ。
- 初期表示上限は10件。

---

# 5. GUIアイテム操作ルール

EconomiCraft は、実際の ItemStack をGUI要素として利用します。

プレイヤーは「アイテムを取ろうとする操作」でUIを操作します。

これは意図的な仕様です。

---

## 5.1 クリック操作

対応:

- 左クリック
- 右クリック

非対応:

- Shiftクリック
- 数字キー入れ替え
- ドラッグ操作
- ダブルクリック回収

---

## 5.2 アイテム取得防止

GUIアイテムがインベントリへ入った場合:

1. 本来の処理を実行する。
2. インベントリを走査する。
3. EconomiCraft GUIアイテムを検出する。
4. 即座に削除する。

処理例:

```text
Click
↓
処理実行
↓
Inventory Scan
↓
GUI Item Detect
↓
Delete Item
```

これにより、Minecraft本来の操作感を維持しながら、アイテム複製を防止します。

---

# 6. Sign GUI利用方針

Sign GUI の利用例:

- 検索入力
- カスタム金額入力
- 名前変更

例:

- オークション価格設定
- Bank Custom Deposit
- Team命名

空文字入力は必ずキャンセルとして扱います。

---

# 7. サウンド方針

EconomiCraft は Vanilla のサウンドを使用します。

独自SEによる基本操作の置き換えは禁止します。

理由:

- 没入感を維持する
- Minecraftらしさを保つ
- Addon間の統一性を確保する

---

# 8. Tooltip方針

Tooltip は必要な場合のみ使用します。

使用例:

- オークション説明
- 危険な操作
- Team権限説明

不要な例:

- Backボタン
- 基本ナビゲーション
- 説明不要な機能

---

# 9. 確認画面方針

確認画面を必須とする例:

- Team解散
- 高額取引
- 取り消し不能な操作
- 大量出金
- 管理者コマンド

通常操作は即時実行を優先します。

利便性を最優先とします。

---

# 10. ローディング方針

専用ローディング画面は実装しません。

許可される演出:

- 一瞬だけ空のチェストを表示
- 即時GUI切替

プレイヤー体験を阻害してはなりません。

---

# 11. テーマシステム

複数のGUIテーマをサポートします。

標準テーマ:

- EconomiCraft
- Vanilla
- Hybrid

将来的な追加候補:

- Dark
- Classic RPG
- Custom Resource Pack

テーマ選択はプレイヤー設定で管理します。

---

# 12. Resource Pack対応

GUIアセットは、リソースパックによる差し替えを前提とします。

要件:

- テクスチャ差し替え可能
- ハードコードされた見た目を避ける

許可解像度:

- 16x16
- 32x32
- 64x64

ピクセルアートである限り、高解像度も許可します。

---

# 13. アイコンデザイン方針

推奨スタイル:

- Vanilla風ピクセルアート

ルール:

- Minecraftらしい視認性を保つ
- リアル調イラストは禁止
- アイテムとして自然に見えること

GUI要素もMinecraft世界の一部として扱います。

---

# 14. GUIアイテムモード

対応モード:

EconomiCraft Mode:

- 専用GUIアイテム
- 専用テクスチャ

Vanilla Mode:

- コンパス
- 矢
- バリア
- その他Vanillaアイテム

Hybrid Mode:

- 両者の混合

プレイヤーが自由に選択できます。

---

# 15. 設定メニュー構造

通常プレイヤー:

```text
Client Settings
Accessibility
Addon Settings
Back
Close
```

OPユーザー:

```text
Client Settings
Server Settings
Accessibility
Addon Settings
Back
Close
```

Server Settings は権限保有者のみ表示します。

---

# 16. Addon統合方針

Addon設定は独立したメニューに配置します。

例:

- EconomiCraft Storage
- EconomiCraft TeamPlus

Core機能とAddon機能は視覚的に分離します。

---

# 17. カテゴリ階層

ページ送りより階層化を優先します。

例:

```text
Blocks
└── Diamond
    ├── Diamond
    ├── Diamond Ore
    └── Diamond Block
```

探索しやすさと視認性を向上させます。

---

# 18. アクセシビリティ原則

以下を重視します。

- 少ないクリック数
- 明確な導線
- 慣れ親しんだ操作
- 予測可能な挙動

外部説明を読まなくても理解できるUIを目指します。

---

# 19. Hypixel SkyBlock参考方針

EconomiCraft は Hypixel SkyBlock を参考にします。

ただし:

- サバイバル環境向けに調整する
- 完全再現は行わない
- Vanilla統合を優先する

Hypixel SkyBlock は参考資料であり、必須条件ではありません。

---

# 20. 翻訳方針

Tier 1 文書は必ず:

- UI_GUIDELINES.md
- UI_GUIDELINES_JA.md

をペアで管理します。

英語版を正本（Canonical Source）とし、日本語版は公式翻訳として同期を維持します。

---

# 21. 将来的な拡張

今後追加されるUIシステムも、本ガイドラインに従います。

例:

- Storage
- Quest
- Mail
- Guild
- TeamPlus

拡張ルールの追加は許可されますが、Tier 1 の原則を破ってはなりません。

---

# 22. Menuアイテム

EconomiCraft は「Menu」という専用アイテムを提供します。

標準仕様:

- ホットバー右端に固定。
- /menu コマンドと同一のUIを開く。
- 右クリックで使用。
- 消失時は自動復元。
- ドロップ・保管・移動は禁止。
- Resource Pack による見た目変更をサポート。

設定項目:

restore_mode:
- always（標準）
- first_join
- disabled

サバイバル環境では SkyBlock Hub のような拠点を作りにくいため、利便性向上を目的として導入します。